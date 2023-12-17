package org.sortingmadness;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SortDataController {
    @PostMapping("/sort_int")
    public SortDataModel<Integer[]> sortIntData(@RequestBody SortDataModel<Integer[]> dataModel) {
        try {
            Integer[] data = dataModel.GetData();
            SortingStrategyEnum sortType = this.GetSortType(dataModel.GetSortType());

            Sorter sorter = new Sorter();
            sorter.setSortingStrategy(sortType);
            sorter.getAlgorithm().sort(data);

            dataModel.SetData(data);
            return dataModel;
        } catch (Exception e) {
            dataModel.SetData(new Integer[]{0});
            return dataModel;
        }
    }

    @PostMapping("/sort_double")
    public SortDataModel<Double[]> sortDoubleData(@RequestBody SortDataModel<Double[]> dataModel) {

    }

    @PostMapping("/sort_string")
    public SortDataModel<String> sortStringData(@RequestBody SortDataModel<String> dataModel) {

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
