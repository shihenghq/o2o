package com.o2o.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/12/1
 * Time:9:33
 * Descrption:
 */
@Controller("share-portal")
@RequestMapping("/share")
public class IndexController extends BaseController {

  /**
   * 网站首页
   * @return
     */
  @RequestMapping("/index")
  public ModelAndView index(){
    return new ModelAndView("index");
  }



}
