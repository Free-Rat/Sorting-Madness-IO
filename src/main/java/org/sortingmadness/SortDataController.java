package org.sortingmadness;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;

@RestController
public class SortDataController {
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
    private SortingStrategyEnum GetSortType(String sortType) throws Exception {
        return switch (sortType) {
            case "QUICK_SORT" -> SortingStrategyEnum.QUICK_SORT;
            case "MERGE_SORT" -> SortingStrategyEnum.MERGE_SORT;
            case "BUBBLE_SORT" -> SortingStrategyEnum.BUBBLE_SORT;
            default -> throw new Exception("Nieznany typ sortowania");
        };
    }
}
