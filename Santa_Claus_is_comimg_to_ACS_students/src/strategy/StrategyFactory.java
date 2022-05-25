package strategy;

import enums.CityStrategyEnum;

public class StrategyFactory {
    public Strategy createStrategy(CityStrategyEnum strategyType) {
        if(strategyType.equals(CityStrategyEnum.ID))
            return new IdStrategy();
        else if(strategyType.equals(CityStrategyEnum.NICE_SCORE))
            return new NiceScoreStrategy();
        else if(strategyType.equals(CityStrategyEnum.NICE_SCORE_CITY))
            return new NiceScoreCityStrategy();
        else
            throw new IllegalArgumentException("Accepted strategies: id, niceScore, niceScoreCity");
    }
}
