package tm.elasticsearch.page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @auther: zhangyi
 * @date: 2019/5/27
 * @Description: 封装分页对象,pageNumber默认从0开始
 */
public class DemoPage implements Pageable {

    private Integer pageNumber;

    private Integer pageSize;

    private Long offset;

    private Sort sort;

    public DemoPage(Integer pageNumber,Integer pageSize,Long offset,Sort sort){
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.offset = offset;
        this.sort = sort;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    @Override
    public int getPageNumber() {
        return this.pageNumber;
    }

    @Override
    public int getPageSize() {
        return this.pageSize;
    }

    @Override
    public long getOffset() {
        return this.offset;
    }

    @Override
    public Sort getSort() {
        return this.sort;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
