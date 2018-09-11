<template>
  <div>
    <el-table :data="users" style="width: 100%">
      <el-table-column prop="username" label="用户名" width="180" />
      <el-table-column prop="password" label="密码" width="300" />
      <el-table-column prop="telephone" label="手机号码" width="180" />
      <el-table-column prop="mail" label="邮箱" width="180" />
      <el-table-column prop="remark" label="备注" width="180" />
      <!--<el-table-column label="操作">-->
        <!--<template slot-scope="scope">-->
          <!--<el-button type="primary">主要按钮</el-button>-->
        <!--</template>-->
      <!--</el-table-column>-->
    </el-table>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'Dashboard',
  data() {
    return {
      tableData: [{
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }]
    }
  },
  computed: {
    ...mapGetters([
      'name',
      'users'
    ])
  },
  component: {
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
