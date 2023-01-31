import flash from "./images/small/flash.png";
import rain from "./images/small/rain.png";
import sunny from "./images/small/sunny.png";
import cloudy from "./images/small/cloudy.png";

function SmallRain(props) {
    return <img src={rain} alt="rain" height={"100px"}/>
}

function SmallFlash(props) {
    return <img src={flash} alt="flash" height={"100px"}/>
}

function SmallSunny(props) {
    return <img src={sunny} alt="sunny" height={"100px"}/>
}

function SmallCloudy(props) {
    return <img src={cloudy} alt="cloudy" height={"100px"}/>
}

export default function SmallIcon(props) {
    const ocenaPogody = props.ocenaPogody
    if (ocenaPogody === "STORMY")
        return <SmallFlash />;
    else if (ocenaPogody === "RAINY")
        return <SmallRain />;
    else if (ocenaPogody === "FULL_CLOUDY")
        return <SmallCloudy />;
    else if (ocenaPogody === "CLOUDY")
        return <SmallCloudy />;
    else if (ocenaPogody === "SUNNY")
        return <SmallSunny />;
    else
        return <img src="" alt={ocenaPogody} height={"100px"}/>
}
