import MovieStars from "components/MovieStars";
import './styles.css';

type Props = {
    score: number;
    count: number;
}

function MovieScore( { score, count } : Props ) {

    return (
        <div className="dsmovie-score-container">
            <p className="dsmovie-score-value">{score > 0 ? score.toFixed(1) : '-'}</p>
            <MovieStars score={score}/>
            <p className="dsmovie-score-count">{count > 0 ? count.toFixed(1).concat(' ratings') : 'No reviews'}</p>
        </div>
    );
}

export default MovieScore;