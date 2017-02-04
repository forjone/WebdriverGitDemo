#language: zh-CN
  功能: 登录功能
    场景: 正确的登录
      假如 我用正确的帐号"test1"登录系统
      那么 我能登录成功

    场景:登录
      当 我用帐号"test1"
      而且我用"password1"登录
      那么我能登录成功

  场景大纲:登录2

      当 我用帐号"<username>"
      而且我用"<password>"登录
      那么我能登录成功
    例子:
      |username|password|
      |test1 | pwd1 |
      |test2 | pwd2 |
      |test3 | pwd3 |

    场景: 搜索selenium
      当搜索框输入"selenium"搜索
      那么 打开搜索页面

    场景: 163邮箱登录
      当我打开"http://mail.163.com/"页面
      而且输入帐号"dreamingxuanyu"，密码"forjone1226"
      当我点击登录按钮
      那么我登录成功