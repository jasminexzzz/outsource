package com.jasmine.es.client.biz.dto;

import com.jasmine.es.client.dto.EsSearchItemDTO;
import com.jasmine.es.repository.dto.PermDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.List;

/**
 * @author wangyf
 * @since 0.0.1
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ItemDTO extends EsSearchItemDTO {

    @Field
    private String itemId;
    private String name;
    private Integer amt;
    private String upTime;
    private String desc;


    private List<PermDTO> perms;
}
