package com.o2o.iteam.scanner;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.o2o.iteam.annotation.Module;
import com.o2o.iteam.annotation.Operation;
import com.o2o.iteam.common.util.ConfUtil;
import com.o2o.iteam.common.util.DateUtil;
import com.o2o.manager.model.sys.resource.ResourceModel;
import com.o2o.manager.service.sys.resource.ResourceService;
import com.o2o.manager.service.sys.user.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/23
 * Time:15:51
 * Descrption:扫描自定义注解
 */
@Component
public class ScannerModule implements ApplicationContextAware {

  @Autowired
  private ResourceService resourceService;

  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    //ConfUtil.loadJsonConf("conf.json");
   // ConfUtil.loadJsonArrayConf("menu.json");
   // JSONArray confArray = ConfUtil.getConfArray();
    //JSONObject conf = ConfUtil.getConf();
    if (false) {
      List<ResourceModel> resourceModelList = new ArrayList<ResourceModel>();
      ResourceModel resource = null;
      final Map<String, Object> map = applicationContext.getBeansWithAnnotation(Module.class);
      for (final Object object : map.values()) {
        final Class<? extends Object> clazz = object.getClass();
        final Module module = clazz.getAnnotation(Module.class);
        System.out.println(module.code() + "----------------------------------" + module.title() + "-----------------------------" + module.url());
        resource = new ResourceModel();
        resource.setCode(module.code());
        resource.setTitle(module.title());
        resource.setCreate_time(DateUtil.currentStr(DateUtil.FORMAT_yyyy_MM_dd_HH_mm_ss));
        resource.setEnabled(true);
        resource.setSeq(1);
        resource.setUrl(module.url());

        resourceModelList.add(resource);

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
          if (field.isAnnotationPresent(Operation.class)) {
            Operation operation = field.getAnnotation(Operation.class);
            System.out.println(operation.code() + "==========================" + operation.name());
          }
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
          if (method.isAnnotationPresent(Operation.class)) {
            Operation operation = method.getAnnotation(Operation.class);
            System.out.println(operation.code() + "==========================" + operation.name());
          }
        }
      }

      if (resourceModelList.size() > 0) {
        for (ResourceModel rs : resourceModelList) {
          resourceService.insert(rs);
        }
      }
    }
  }

  /*@Autowired
  private UserService userService;

  public void onApplicationEvent(ContextRefreshedEvent event) {
    final Map<String, Object> map = event.getApplicationContext().getBeansWithAnnotation(Module.class);

    for (final Object module : map.values()) {
      final Class<? extends Object> fooClass = module.getClass();
      final Module annotation = fooClass.getAnnotation(Module.class);
      System.out.println(annotation.code()+"----------------------------------"+annotation.title());
    }

    System.out.println(userService+"============================");
  }*/
}
