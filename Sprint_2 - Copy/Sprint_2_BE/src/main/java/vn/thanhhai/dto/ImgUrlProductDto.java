package vn.thanhhai.dto;

public class ImgUrlProductDto {
    private Integer id;
    private String url;
    private Integer watch;

    public ImgUrlProductDto(Integer id, String url, Integer watch) {
        this.id = id;
        this.url = url;
        this.watch = watch;
    }

    public ImgUrlProductDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWatch() {
        return watch;
    }

    public void setWatch(Integer watch) {
        this.watch = watch;
    }
}
