<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="企业ID" prop="companyId">
        <el-input
          v-model="queryParams.companyId"
          placeholder="请输入企业ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="企业名称" prop="companyName">
        <el-input
          v-model="queryParams.companyName"
          placeholder="请输入企业名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地区" prop="companyArea">
        <el-input
          v-model="queryParams.companyArea"
          placeholder="请输入地区"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系人" prop="companyLinkmain">
        <el-input
          v-model="queryParams.companyLinkmain"
          placeholder="请输入联系人"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:infor:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:infor:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:infor:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
		  :loading="exportLoading"
          @click="handleExport"
          v-hasPermi="['system:infor:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="inforList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="企业ID" align="center" prop="companyId" />
      <el-table-column label="企业名称" align="center" prop="companyName" />
      <el-table-column label="地区" align="center" prop="companyArea" />
      <el-table-column label="地址" align="center" prop="companyAddress" />
      <el-table-column label="联系人" align="center" prop="companyLinkmain" />
      <el-table-column label="联系方式" align="center" prop="companyPhone" />
      <el-table-column label="建立时间" align="center" prop="companySetuptime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.companySetuptime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="企业性质" align="center" prop="companyNature" />
      <el-table-column label="注册资金" align="center" prop="companyRegmoney" />
      <el-table-column label="固定资产" align="center" prop="companyFxedassets" />
      <el-table-column label="网址" align="center" prop="companyUrl" />
      <el-table-column label="电子邮件地址" align="center" prop="companyEmail" />
      <el-table-column label="注册人" align="center" prop="companyCreateperson" />
      <el-table-column label="注册时间" align="center" prop="companyCreatedate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.companyCreatedate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:infor:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:infor:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改用户管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="企业名称" prop="companyName">
          <el-input v-model="form.companyName" placeholder="请输入企业名称" />
        </el-form-item>
        <el-form-item label="地区" prop="companyArea">
<!--          <el-input v-model="form.companyArea" placeholder="请输入地区" />-->
          <el-cascader
            v-model="form.companyArea"
            :options="city"
            :props="{ expandTrigger: 'hover',value:'cat_id',label:'cat_name'}"
            @change="handleChange">
          </el-cascader>
        </el-form-item>
        <el-form-item label="地址" prop="companyAddress">
          <el-input v-model="form.companyAddress" placeholder="请输入地址" />
        </el-form-item>
        <el-form-item label="联系人" prop="companyLinkmain">
          <el-input v-model="form.companyLinkmain" placeholder="请输入联系人" />
        </el-form-item>
        <el-form-item label="联系方式" prop="companyPhone">
          <el-input v-model="form.companyPhone" placeholder="请输入联系方式" />
        </el-form-item>
        <el-form-item label="建立时间" prop="companySetuptime">
          <el-date-picker clearable size="small"
            v-model="form.companySetuptime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择建立时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="企业性质" prop="companyNature">
          <el-input v-model="form.companyNature" placeholder="请输入企业性质" />
        </el-form-item>
        <el-form-item label="注册资金" prop="companyRegmoney">
          <el-input v-model="form.companyRegmoney" placeholder="请输入注册资金" />
        </el-form-item>
        <el-form-item label="固定资产" prop="companyFxedassets">
          <el-input v-model="form.companyFxedassets" placeholder="请输入固定资产" />
        </el-form-item>
        <el-form-item label="网址" prop="companyUrl">
          <el-input v-model="form.companyUrl" placeholder="请输入网址" />
        </el-form-item>
        <el-form-item label="电子邮件地址" prop="companyEmail">
          <el-input v-model="form.companyEmail" placeholder="请输入电子邮件地址" />
        </el-form-item>
        <el-form-item label="注册人" prop="companyCreateperson">
          <el-input v-model="form.companyCreateperson" placeholder="请输入注册人" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listInfor, getInfor, delInfor, addInfor, updateInfor, exportInfor } from "@/api/system/infor";
import axios from "axios";

export default {
  name: "Infor",
  components: {
  },
  data() {
    return {

      city: null,
      value: [],

      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 用户管理表格数据
      inforList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        companyId: null,
        companyName: null,
        companyArea: null,
        companyLinkmain: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        companyName: [
          { required: true, message: "企业名称不能为空", trigger: "blur" }
        ],
        companyArea: [
          { required: true, message: "地区不能为空", trigger: "blur" }
        ],
        companyAddress: [
          { required: true, message: "地址不能为空", trigger: "blur" }
        ],
        companyLinkmain: [
          { required: true, message: "联系人不能为空", trigger: "blur" }
        ],
        companyPhone: [
          { required: true, message: "联系方式不能为空", trigger: "blur" }
        ],
        companyDelflag: [
          { required: true, message: "删除标志不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
    axios.get('/2020年最新全国行政区划element多级选择value-code.json').then(response => this.city = response.data);
  },
  methods: {

    handleChange(value) {console.log(value);},

    /** 查询用户管理列表 */
    getList() {
      this.loading = true;
      listInfor(this.queryParams).then(response => {
        this.inforList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        companyId: null,
        companyCode: null,
        companyName: null,
        companyArea: null,
        companyAddress: null,
        companyLinkmain: null,
        companyPhone: null,
        companySetuptime: null,
        companyNature: null,
        companyRegmoney: null,
        companyFxedassets: null,
        companyUrl: null,
        companyEmail: null,
        companyCreateperson: null,
        companyCreatedate: null,
        companyDelflag: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.companyId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加用户管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const companyId = row.companyId || this.ids
      getInfor(companyId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改用户管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.companyId != null) {
            updateInfor(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            },);
          } else {
            addInfor(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const companyIds = row.companyId || this.ids;
      this.$confirm('是否确认删除用户管理编号为"' + companyIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delInfor(companyIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有用户管理数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.exportLoading = true;
          return exportInfor(queryParams);
        }).then(response => {
          this.download(response.msg);
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
