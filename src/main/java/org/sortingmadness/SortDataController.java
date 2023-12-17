package org.sortingmadness;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;

@RestController
public class SortDataController {
    @PostMapping("/sort_int")
    public SortDataModel<Integer[]> sortIntData(@RequestBody SortDataModel<Integer[]> dataModel) {
        Integer[] data = dataModel.getData();
        Sorter sorter = new Sorter();
        sorter.setSortingStrategy(SortingStrategyEnum.BUBBLE_SORT);
        sorter.getAlgorithm().sort(data);
        dataModel.setData(data);
        return dataModel;
    }
}
