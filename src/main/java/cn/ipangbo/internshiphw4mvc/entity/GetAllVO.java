package cn.ipangbo.internshiphw4mvc.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class GetAllVO {
    private int status;
    private List<User> data;
}
