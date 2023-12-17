package org.sortingmadness;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;

@RestController
/**
 * Klasa obsługująca żądania POST sortowania danych
 */
public class SortDataController {
    /**
     * Obsługa żądania POST sortowania danych (int)
     * @param dataModel
     * @return posortowane dataModel (int)
     * @throws Exception ("Nieznany typ sortowania")
     */
    @PostMapping("/sort_int") // handle Integer sorting POST request
    public SortDataModel<Integer[]> sortIntData(@RequestBody SortDataModel<Integer[]> dataModel) throws Exception {
        Integer[] data = dataModel.getData();
        var sortType = this.GetSortType(dataModel.getSortType());
        Sorter sorter = new Sorter();
        sorter.setSortingStrategy(sortType);
        sorter.getAlgorithm().sort(data);
        dataModel.setData(data);
        return dataModel;
    }

    /**
     * Obsługa żądania POST sortowania danych (double)
     * @param dataModel
     * @return posoto dataModel (double)
     * @throws Exception ("Nieznany typ sortowania")
     */
    @PostMapping("/sort_double") // handle double sorting POST request
    public SortDataModel<double[]> sortDoubleData(@RequestBody SortDataModel<double[]> dataModel) throws Exception {
        double[] data = dataModel.getData();
        var sortType = this.GetSortType(dataModel.getSortType());
        Sorter sorter = new Sorter();
        sorter.setSortingStrategy(sortType);
        sorter.getAlgorithm().sort(data);
        dataModel.setData(data);
        return dataModel;
    }
    /**
     * Obsługa żądania POST sortowania danych (String)
     * @param dataModel
     * @return posortowane dataModel (String)
     * @throws Exception ("Nieznany typ sortowania")
     */
    @PostMapping("/sort_string") // handle String sorting POST request
    public SortDataModel<String> sortStringData(@RequestBody SortDataModel<String> dataModel) throws Exception {
        String data = dataModel.getData();
        var sortType = this.GetSortType(dataModel.getSortType());
        Sorter sorter = new Sorter();
        sorter.setSortingStrategy(sortType);
        sorter.getAlgorithm().sort(data);
        dataModel.setData(data);
        return dataModel;
    }
    /**
     * Determinuje typ sortowania
     * @param sortType
     * @return typ sortowania
     * @throws Exception ("Nieznany typ sortowania")
     */
    private SortingStrategyEnum GetSortType(String sortType) throws Exception {
        return switch (sortType) {
            case "QUICK_SORT" -> SortingStrategyEnum.QUICK_SORT;
            case "MERGE_SORT" -> SortingStrategyEnum.MERGE_SORT;
            case "BUBBLE_SORT" -> SortingStrategyEnum.BUBBLE_SORT;
            default -> throw new Exception("Nieznany typ sortowania");
        };
    }
}