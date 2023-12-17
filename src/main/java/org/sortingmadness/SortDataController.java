package org.sortingmadness;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;

@RestController
public class SortDataController {
    @PostMapping("/sort_int")
    public SortDataModel<Integer[]> sortIntData(@RequestBody SortDataModel<Integer[]> dataModel) throws Exception {
        Integer[] data = dataModel.getData();
        var sortType = this.GetSortType(dataModel.getSortType());
        Sorter sorter = new Sorter();
        sorter.setSortingStrategy(SortingStrategyEnum.BUBBLE_SORT);
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
