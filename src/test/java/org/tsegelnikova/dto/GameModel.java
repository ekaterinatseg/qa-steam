package org.tsegelnikova.dto;

import java.util.List;
import java.util.Objects;

public class GameModel {
    public GameModel(String name, List<String> platforms, String releaseDate, String reviewSummaryResult, String price) {
        this.name = name;
        this.platforms = platforms;
        this.releaseDate = releaseDate;
        this.reviewSummaryResult = reviewSummaryResult;
        this.price = price;
    }

    private String name;
    private List<String> platforms;
    private String releaseDate;
    private String reviewSummaryResult;
    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<String> platforms) {
        this.platforms = platforms;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReviewSummaryResult() {
        return reviewSummaryResult;
    }

    public void setReviewSummaryResult(String reviewSummaryResult) {
        this.reviewSummaryResult = reviewSummaryResult;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameModel gameModel = (GameModel) o;

        if (!Objects.equals(name, gameModel.name)) return false;
        if (!Objects.equals(platforms, gameModel.platforms)) return false;
        if (!Objects.equals(releaseDate, gameModel.releaseDate))
            return false;
        if (!Objects.equals(reviewSummaryResult, gameModel.reviewSummaryResult))
            return false;
        return Objects.equals(price, gameModel.price);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (platforms != null ? platforms.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (reviewSummaryResult != null ? reviewSummaryResult.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GameModel{" +
                "name='" + name + '\'' +
                ", platforms=" + platforms +
                ", releaseDate='" + releaseDate + '\'' +
                ", reviewSummaryResult='" + reviewSummaryResult + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
