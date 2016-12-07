package com.o2o.manager.controller.user;

import com.o2o.iteam.code.Result;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/18
 * Time:9:53
 * Descrption:
 */
@Controller
public class LoginController {

  private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

  /**
   * 首页
   *
   * @return
   */
  @RequestMapping(value = "/")
  public String index() {
    return "redirect:/index";
  }

  /**
   * 首页
   *
   * @param model
   * @return
   */
  @RequestMapping(value = "/index")
  public String index(Model model) {
    return "/index";
  }

  /**
   * GET 登录
   *
   * @param model
   * @param request
   * @return
   */
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login(Model model, HttpServletRequest request) {
     LOGGER.info("GET请求登录");
    if (SecurityUtils.getSubject().isAuthenticated()) {
      return "redirect:/index";
    }
    return "/login";
  }

  /**
   *  @param model
   *  @param request
   * 登出
   * @return
     */
  @RequestMapping(value = "/logout", method = {RequestMethod.POST} )
  public String logout(Model model, HttpServletRequest request){
    return "redirect:/logout";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @ResponseBody
  public Result loginPost(String username, String password, HttpServletRequest request, Model model) {
    LOGGER.info("POST请求登录");
    Result result = new Result();
    if (StringUtils.isBlank(username)) {
      result.setMsg("用户名不能为空");
      return result;
    }
    if (StringUtils.isBlank(password)) {
      result.setMsg("密码不能为空");
      return result;
    }
    Subject user = SecurityUtils.getSubject();
    UsernamePasswordToken token = new UsernamePasswordToken(username, DigestUtils.md5Hex(password).toCharArray());
    token.setRememberMe(true);
    try {
      user.login(token);
    } catch (UnknownAccountException e) {
      LOGGER.error("账号不存在：{}", e);
      result.setMsg("账号不存在");
      return result;
    } catch (DisabledAccountException e) {
      LOGGER.error("账号未启用：{}", e);
      result.setMsg("账号未启用");
      return result;
    } catch (IncorrectCredentialsException e) {
      LOGGER.error("密码错误：{}", e);
      result.setMsg("密码错误");
      return result;
    } catch (RuntimeException e) {
      LOGGER.error("未知错误,请联系管理员：{}", e);
      result.setMsg("未知错误,请联系管理员");
      return result;
    }
    result.setSuccess(true);
    return result;
  }
}
