<template>
<div class="wrapper">
  <div style="margin: 200px auto; background-color: #fff;width: 350px;height:300px;padding: 20px;border-radius: 10px">
    <div style="margin: 20px 0;text-align: center;font-size: 24px;"><b>登陆</b></div>
    <el-form :model="user" :rules="rules" ref="userForm" >
      <el-form-item prop="username">
        <el-input placeholder="请输入账号" size="medium" style="margin: 10px 0" prefix-icon="el-icon-user" v-model="user.username"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input placeholder="请输入密码"  size="medium" style="margin: 10px 0" prefix-icon="el-icon-lock" show-password v-model="user.password"></el-input>
      </el-form-item>
      <div style= "margin: 10px 0; text-align: right">
        <el-button type="primary" size="small" style="margin-right: 84px" @click="$router.push('/test')">游客看一看</el-button>
        <el-button type="primary" size="small" autocomplete="off" @click="login">登陆</el-button>
        <el-button type="warning" size="small" autocomplete="off" @click="$router.push('/register')">注册</el-button>
      </div>
    </el-form>
  </div>
</div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      //将用户名和密码绑定到user对象中，当点击时，发送给后台，然后进行校验，成功跳转到主页面，否则提示错误
      user: {},
      rules: {
        username: [
          {required: true, message: '请输入用户名', trigger: 'blur'},
          {min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 3, max: 20, message: '长度在 3 到 20 个字符', trigger: 'blur'}
        ],
      }
    }
  },
  methods: {
    login() {
      //先度输入的进行校验，若有错，就不向后台发送了,valid是否合法
      this.$refs['userForm'].validate((valid) => {
        //校验合法
        if (valid) {
          //后台要有接口对其进行接收,请求后台的login，进行处理数据
          this.request.post("/user/login",this.user).then(res => {
            if (res.code == '200') {
              localStorage.setItem("user",JSON.stringify(res.data)) // 存储用户信息到浏览器
              this.$router.push("/")
              this.$message.success("登陆成功")
            }
            else {
              this.$message.error(res.msg)
            }
          })
        }
      });
    }
  }
}
</script>

<style scoped>
.wrapper {
  height: 100vh;
  background-image: linear-gradient(to bottom right, #48dc99, #3b58ea);
  overflow: hidden;
}
</style>