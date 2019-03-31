package nz.co.cocca.test.javatest.vo;
import lombok.Data;

import java.util.List;

@Data
public class ResultVo {

    private int page;
    private int perPage;
    private int total;
    private int totalPages;
    private List<User> data;
}
