<template>
  <div>
    <h1>Hello AI!!!</h1>
    <div>
      <el-upload
          class="upload-demo"
          action="http://localhost:9090/pic"
          :on-success="handleSuccess">
        <el-button size="small" type="primary">点击上传</el-button>
        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
      </el-upload>
      <el-input
          style="margin-top: 10px;width: 500px;height: 500px;"
          type="textarea"
          :rows="10"
          placeholder="结果展示在这里"
          v-model="words"
      ></el-input>
    </div>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      words: ''
    }
  },
  methods: {
    handleSuccess(res) {
      this.words = res; //打印到前端文本框中，words上方的v-model的名字
    }
  }
}
</script>


<style scoped>

</style>