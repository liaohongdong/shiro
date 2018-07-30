package cn.liaohongdong.param;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Setter
@Getter
public class UserParam {
    @NotBlank
    @Length(min = 0, max = 100, message = "用户名长度不正确")
    private String username;

    @NotBlank
    @URL(message = "URL不合法")
    private String telephone;
}
