import bigRain from "./images/big/big_rain.png";
import bigFlash from "./images/big/big_flash.png";
import bigRainClouds from "./images/big/big_rain_clouds.png";
import bigSnow from "./images/big/big_snow.png";
import bigSunCloudRain from "./images/big/big_sun_cloud_rain.png";
import ReactDOM from "react-dom";

function BigRain(props) {
    return <img src={bigRain} alt="rain" height={"45%"}/>
}

function BigSnow(props) {
    return <img src={bigSnow} alt="rain" height={"45%"}/>
}

function BigSunCloudRain(props) {
    return <img src={bigSunCloudRain} alt="rain" height={"45%"}/>
}

function BigRainClouds(props) {
    return <img src={bigRainClouds} alt="rain" height={"45%"}/>
}

function BigFlash(props) {
    return <img src={bigFlash} alt="rain" height={"45%"}/>
}

export default function BigIcon(props) {
    const ocenaPogody = props.ocenaPogody
    if (ocenaPogody === "STORMY")
        return <BigFlash />;
    else if (ocenaPogody === "RAINY")
        return <BigRain />;
    else if (ocenaPogody === "FULL_CLOUDY")
        return <BigRainClouds />;
    else if (ocenaPogody === "CLOUDY")
        return <BigSunCloudRain />;
    else if (ocenaPogody === "SUNNY")
        return <BigRain />;
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<BigIcon ocenaPogody="SUNNY" />);