import cloudy from "./images/small/cloudy.png";
import wind from "./images/wind.png";
import humidity from "./images/humidity.png";
import SmallIcon from "./SmallIconComponent";

export default function ForecastBadge(props) {
    const danePogodoweDto = props.danePogodoweDto
    return <><header className="center biggerText">{danePogodoweDto.czasOdczytu.toLocaleDateString('en-US', {weekday: 'short'}).toUpperCase()}</header>
        <SmallIcon ocenaPogody={danePogodoweDto.ocenaPogody}></SmallIcon>
        <p className="center biggerText">{danePogodoweDto.temperaturaZewnetrzna}&#176;C</p>
        <p>
            <img
                src={wind}
                alt="wind icon"
                height={"20px"}
                className="smallIcon"
            />
            {danePogodoweDto.predkoscWiatru} km/h
        </p>
        <p>
            <img
                src={humidity}
                alt="humidity icon"
                height={"18px"}
                className="smallIcon"
            />
            {danePogodoweDto.opadyDeszczu}%
        </p>
        </>
}
