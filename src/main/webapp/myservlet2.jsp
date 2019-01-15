<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset = "utf-8">
    <title>Co ja pacze?</title>
    <script src='OSC.js'></script>
    <script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
</head>

<body>

Jest godzina: <span id='time'>00:00:00</span><br>

<script>
    setInterval("showtime(O('time'))", 1000)

    function showtime(object)
    {
        var date = new Date()
        object.innerHTML = date.toTimeString().substr(0,8)
    }
</script>

<p><font size="20"><strong><b><mark>Co ja pacze?</strong></b></mark><br/></font></p>

<div id='status'></div>
<div id='map'></div>

<script>
    if (typeof navigator.geolocation == 'undefined')
        alert("Funkcja geolokacji nie jest obsługiwana.")
    else
        navigator.geolocation.getCurrentPosition(granted, denied)

    function granted(position)
    {

        alert("Jesteś tutaj:\n"
            + position.coords.latitude + ", "
            + position.coords.longitude)

        O('status').innerHTML = 'Pozwolenie przyznane'
        S('map').border       = '1px solid black'
        S('map').width        = '640px'
        S('map').height       = '320px'

        var lat   = position.coords.latitude
        var long  = position.coords.longitude
        var gmap  = O('map')
        var gopts =
            {
                center: new google.maps.LatLng(lat, long),
                zoom: 9, mapTypeId: google.maps.MapTypeId.ROADMAP
            }
        var map = new google.maps.Map(gmap, gopts)
    }

    function denied(error)
    {
        var message

        switch(error.code)
        {
            case 1: message = 'Brak pozwolenia'; break;
            case 2: message = 'Położenie niedostępne'; break;
            case 3: message = 'Przekroczony czas operacji'; break;
            case 4: message = 'Nieznany błąd'; break;
        }

        alert("Błąd w ustalaniu położenia: " + message)
        O('status').innerHTML = message
    }

</script>

<video width="600" height="400" autoplay loop>
    <source src="movie.mp4" type="video/mp4">
    Your browser does not support the video tag.
</video>

<img src="co_ja_pacze.jpg" alt="Pacze_TU">