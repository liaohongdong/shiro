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
//        SysShiroRolesService sysShiroRolesService = ApplicationContextHelper.popBean(SysShiroRolesService.class);
        List<SysShiroRoles> item = sysShiroRolesService.getRolesItem();
        for(SysShiroRoles s : item){
            map.put(s.getUrl(), s.getMethod());
        }
//        map.put("/admin/doLogin","anon");
//        map.put("/admin/logout","logout");
//        map.put("/admin/admin","roles[admin]");
//        map.put("/admin/user","roles[user]");
//        map.put("/**","authc");
        return map;
    }
}
