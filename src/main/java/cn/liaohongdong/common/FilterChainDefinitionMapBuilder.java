package cn.liaohongdong.common;

import cn.liaohongdong.model.SysShiroRoles;
import cn.liaohongdong.service.SysShiroRolesService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;

public class FilterChainDefinitionMapBuilder {
    @Autowired
    private SysShiroRolesService sysShiroRolesService;

    public LinkedHashMap<String, String> build() {
        LinkedHashMap<String, String> map = Maps.newLinkedHashMap();
        List<SysShiroRoles> item = sysShiroRolesService.getRolesItem();
        for(SysShiroRoles s : item){
            map.put(s.getUrl(), s.getMethod());
        }
        return map;
    }
}
