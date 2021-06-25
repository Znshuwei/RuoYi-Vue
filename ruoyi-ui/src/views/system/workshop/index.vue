<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="车间名称" prop="manageWorkshopName">
        <el-input
          v-model="queryParams.manageWorkshopName"
          placeholder="请输入车间名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车间地区" prop="manageWorkshopArea">
        <el-input
          v-model="queryParams.manageWorkshopArea"
          placeholder="请输入车间地区"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车间负责人" prop="manageWorkshopManager">
        <el-input
          v-model="queryParams.manageWorkshopManager"
          placeholder="请输入车间负责人"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车间状态flag" prop="manageWorkshopStatusflag">
        <el-input
          v-model="queryParams.manageWorkshopStatusflag"
          placeholder="请输入车间状态flag"
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
          v-hasPermi="['system:workshop:add']"
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
          v-hasPermi="['system:workshop:edit']"
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
          v-hasPermi="['system:workshop:remove']"
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
          v-hasPermi="['system:workshop:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="workshopList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="车间编号" align="center" prop="manageWorkshopId" />
      <el-table-column label="车间名称" align="center" prop="manageWorkshopName" />
      <el-table-column label="车间地区" align="center" prop="manageWorkshopArea" />
      <el-table-column label="车间地址" align="center" prop="manageWorkshopAddress" />
      <el-table-column label="车间负责人" align="center" prop="manageWorkshopManager" />
      <el-table-column label="负责人联系方式" align="center" prop="manageWorkshopMngphone" />
      <el-table-column label="车间注册时间" align="center" prop="manageWorkshopCreatetime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.manageWorkshopCreatetime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="车间状态flag" align="center" prop="manageWorkshopStatusflag" />
      <el-table-column label="删除标志" align="center" prop="manageWorkshopDelflag" />
      <el-table-column label="备注" align="center" prop="manageWorkshopRemark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:workshop:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:workshop:remove']"
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

    <!-- 添加或修改车间数据对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="车间名称" prop="manageWorkshopName">
          <el-input v-model="form.manageWorkshopName" placeholder="请输入车间名称" />
        </el-form-item>
        <el-form-item label="车间地区" prop="manageWorkshopArea">
          <el-input v-model="form.manageWorkshopArea" placeholder="请输入车间地区" />
        </el-form-item>
        <el-form-item label="车间地址" prop="manageWorkshopAddress">
          <el-input v-model="form.manageWorkshopAddress" placeholder="请输入车间地址" />
        </el-form-item>
        <el-form-item label="车间负责人" prop="manageWorkshopManager">
          <el-input v-model="form.manageWorkshopManager" placeholder="请输入车间负责人" />
        </el-form-item>
        <el-form-item label="负责人联系方式" prop="manageWorkshopMngphone">
          <el-input v-model="form.manageWorkshopMngphone" placeholder="请输入负责人联系方式" />
        </el-form-item>
        <el-form-item label="车间注册时间" prop="manageWorkshopCreatetime">
          <el-date-picker clearable size="small"
            v-model="form.manageWorkshopCreatetime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择车间注册时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="车间状态flag" prop="manageWorkshopStatusflag">
          <el-input v-model="form.manageWorkshopStatusflag" placeholder="请输入车间状态flag" />
        </el-form-item>
        <el-form-item label="删除标志" prop="manageWorkshopDelflag">
          <el-input v-model="form.manageWorkshopDelflag" placeholder="请输入删除标志" />
        </el-form-item>
        <el-form-item label="备注" prop="manageWorkshopRemark">
          <el-input v-model="form.manageWorkshopRemark" placeholder="请输入备注" />
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
import { listWorkshop, getWorkshop, delWorkshop, addWorkshop, updateWorkshop, exportWorkshop } from "@/api/system/workshop";

export default {
  name: "Workshop",
  components: {
  },
  data() {
    return {
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
      // 车间数据表格数据
      workshopList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        manageWorkshopName: null,
        manageWorkshopArea: null,
        manageWorkshopManager: null,
        manageWorkshopStatusflag: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        manageWorkshopId: [
          { required: true, message: "车间编号不能为空", trigger: "blur" }
        ],
        manageWorkshopName: [
          { required: true, message: "车间名称不能为空", trigger: "blur" }
        ],
        manageWorkshopArea: [
          { required: true, message: "车间地区不能为空", trigger: "blur" }
        ],
        manageWorkshopAddress: [
          { required: true, message: "车间地址不能为空", trigger: "blur" }
        ],
        manageWorkshopManager: [
          { required: true, message: "车间负责人不能为空", trigger: "blur" }
        ],
        manageWorkshopMngphone: [
          { required: true, message: "负责人联系方式不能为空", trigger: "blur" }
        ],
        manageWorkshopCreatetime: [
          { required: true, message: "车间注册时间不能为空", trigger: "blur" }
        ],
        manageWorkshopStatusflag: [
          { required: true, message: "车间状态flag不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询车间数据列表 */
    getList() {
      this.loading = true;
      listWorkshop(this.queryParams).then(response => {
        this.workshopList = response.rows;
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
        manageWorkshopId: null,
        manageWorkshopName: null,
        manageWorkshopArea: null,
        manageWorkshopAddress: null,
        manageWorkshopManager: null,
        manageWorkshopMngphone: null,
        manageWorkshopCreatetime: null,
        manageWorkshopStatusflag: null,
        manageWorkshopDelflag: null,
        manageWorkshopRemark: null
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
      this.ids = selection.map(item => item.manageWorkshopId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加车间数据";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const manageWorkshopId = row.manageWorkshopId || this.ids
      getWorkshop(manageWorkshopId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改车间数据";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.manageWorkshopId != null) {
            updateWorkshop(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addWorkshop(this.form).then(response => {
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
      const manageWorkshopIds = row.manageWorkshopId || this.ids;
      this.$confirm('是否确认删除车间数据编号为"' + manageWorkshopIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delWorkshop(manageWorkshopIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有车间数据数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.exportLoading = true;
          return exportWorkshop(queryParams);
        }).then(response => {
          this.download(response.msg);
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
