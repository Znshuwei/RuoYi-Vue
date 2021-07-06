<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="刀具名称" prop="manageToolsName">
        <el-input
          v-model="queryParams.manageToolsName"
          placeholder="请输入刀具名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="刀具型号" prop="manageToolsModel">
        <el-input
          v-model="queryParams.manageToolsModel"
          placeholder="请输入刀具型号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属车间" prop="manageToolsWkshopid">
        <el-input
          v-model="queryParams.manageToolsWkshopid"
          placeholder="请输入所属车间"
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
          v-hasPermi="['system:tools:add']"
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
          v-hasPermi="['system:tools:edit']"
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
          v-hasPermi="['system:tools:remove']"
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
          v-hasPermi="['system:tools:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="toolsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="刀具ID
" align="center" prop="manageToolsId" />
      <el-table-column label="刀具名称" align="center" prop="manageToolsName" />
      <el-table-column label="刀具型号" align="center" prop="manageToolsModel" />
      <el-table-column label="刀具材料" align="center" prop="manageToolsMaterial" />
      <el-table-column label="刀具刃数" align="center" prop="manageToolsBlades" />
      <el-table-column label="单支价格" align="center" prop="manageToolsPrice" />
      <el-table-column label="所属车间" align="center" prop="manageToolsWkshopid" />
      <el-table-column label="库存量" align="center" prop="manageToolsNumber" />
      <el-table-column label="备注" align="center" prop="manageToolsRemark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:tools:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:tools:remove']"
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

    <!-- 添加或修改刀具数据对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="刀具名称" prop="manageToolsName">
          <el-input v-model="form.manageToolsName" placeholder="请输入刀具名称" />
        </el-form-item>
        <el-form-item label="刀具型号" prop="manageToolsModel">
          <el-input v-model="form.manageToolsModel" placeholder="请输入刀具型号" />
        </el-form-item>
        <el-form-item label="刀具材料" prop="manageToolsMaterial">
          <el-input v-model="form.manageToolsMaterial" placeholder="请输入刀具材料" />
        </el-form-item>
        <el-form-item label="刀具刃数" prop="manageToolsBlades">
          <el-input v-model="form.manageToolsBlades" placeholder="请输入刀具刃数" />
        </el-form-item>
        <el-form-item label="单支价格" prop="manageToolsPrice">
          <el-input v-model="form.manageToolsPrice" placeholder="请输入单支价格" />
        </el-form-item>
        <el-form-item label="所属车间" prop="manageToolsWkshopid">
          <el-input v-model="form.manageToolsWkshopid" placeholder="请输入所属车间" />
        </el-form-item>
        <el-form-item label="库存量" prop="manageToolsNumber">
          <el-input v-model="form.manageToolsNumber" placeholder="请输入库存量" />
        </el-form-item>
        <el-form-item label="备注" prop="manageToolsRemark">
          <el-input v-model="form.manageToolsRemark" placeholder="请输入备注" />
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
import { listTools, getTools, delTools, addTools, updateTools, exportTools } from "@/api/system/tools";

export default {
  name: "Tools",
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
      // 刀具数据表格数据
      toolsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        manageToolsName: null,
        manageToolsModel: null,
        manageToolsWkshopid: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        manageToolsName: [
          { required: true, message: "刀具名称不能为空", trigger: "blur" }
        ],
        manageToolsModel: [
          { required: true, message: "刀具型号不能为空", trigger: "blur" }
        ],
        manageToolsMaterial: [
          { required: true, message: "刀具材料不能为空", trigger: "blur" }
        ],
        manageToolsPrice: [
          { required: true, message: "单支价格不能为空", trigger: "blur" }
        ],
        manageToolsWkshopid: [
          { required: true, message: "所属车间不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询刀具数据列表 */
    getList() {
      this.loading = true;
      listTools(this.queryParams).then(response => {
        this.toolsList = response.rows;
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
        manageToolsId: null,
        manageToolsName: null,
        manageToolsModel: null,
        manageToolsMaterial: null,
        manageToolsBlades: null,
        manageToolsPrice: null,
        manageToolsWkshopid: null,
        manageToolsNumber: null,
        manageToolsRemark: null
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
      this.ids = selection.map(item => item.manageToolsId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加刀具数据";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const manageToolsId = row.manageToolsId || this.ids
      getTools(manageToolsId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改刀具数据";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.manageToolsId != null) {
            updateTools(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTools(this.form).then(response => {
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
      const manageToolsIds = row.manageToolsId || this.ids;
      this.$confirm('是否确认删除刀具数据编号为"' + manageToolsIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delTools(manageToolsIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有刀具数据数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.exportLoading = true;
          return exportTools(queryParams);
        }).then(response => {
          this.download(response.msg);
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
