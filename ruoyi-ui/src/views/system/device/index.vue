<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="设备名称" prop="manageDeviceName">
        <el-input
          v-model="queryParams.manageDeviceName"
          placeholder="请输入设备名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备型号" prop="manageDeviceModel">
        <el-input
          v-model="queryParams.manageDeviceModel"
          placeholder="请输入设备型号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备所属车间ID" prop="manageDeviceWkshopid">
        <el-input
          v-model="queryParams.manageDeviceWkshopid"
          placeholder="请输入设备所属车间ID"
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
          v-hasPermi="['system:device:add']"
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
          v-hasPermi="['system:device:edit']"
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
          v-hasPermi="['system:device:remove']"
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
          v-hasPermi="['system:device:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="deviceList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="设备ID" align="center" prop="manageDeviceId" />
      <el-table-column label="设备名称" align="center" prop="manageDeviceName" />
      <el-table-column label="设备型号" align="center" prop="manageDeviceModel" />
      <el-table-column label="设备所属车间ID" align="center" prop="manageDeviceWkshopid" />
      <el-table-column label="设备运行状态" align="center" prop="manageDeviceRunstatus" />
      <el-table-column label="设备开始运行日期" align="center" prop="manageDeviceRundate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.manageDeviceRundate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="设备运行时间" align="center" prop="manageDeviceRunhours" />
      <el-table-column label="设备报废标志" align="center" prop="manageDeviceScrapflag" />
      <el-table-column label="设备删除标志" align="center" prop="manageDeviceDelflag" />
      <el-table-column label="备注" align="center" prop="manageDeviceRemark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:device:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:device:remove']"
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

    <!-- 添加或修改设备数据对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="设备名称" prop="manageDeviceName">
          <el-input v-model="form.manageDeviceName" placeholder="请输入设备名称" />
        </el-form-item>
        <el-form-item label="设备型号" prop="manageDeviceModel">
          <el-input v-model="form.manageDeviceModel" placeholder="请输入设备型号" />
        </el-form-item>
        <el-form-item label="设备所属车间ID" prop="manageDeviceWkshopid">
          <el-input v-model="form.manageDeviceWkshopid" placeholder="请输入设备所属车间ID" />
        </el-form-item>
        <el-form-item label="设备运行状态">
          <el-radio-group v-model="form.manageDeviceRunstatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="设备开始运行日期" prop="manageDeviceRundate">
          <el-date-picker clearable size="small"
            v-model="form.manageDeviceRundate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择设备开始运行日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="设备运行时间" prop="manageDeviceRunhours">
          <el-input v-model="form.manageDeviceRunhours" placeholder="请输入设备运行时间" />
        </el-form-item>
        <el-form-item label="设备报废标志" prop="manageDeviceScrapflag">
          <el-input v-model="form.manageDeviceScrapflag" placeholder="请输入设备报废标志" />
        </el-form-item>
        <el-form-item label="设备删除标志" prop="manageDeviceDelflag">
          <el-input v-model="form.manageDeviceDelflag" placeholder="请输入设备删除标志" />
        </el-form-item>
        <el-form-item label="备注" prop="manageDeviceRemark">
          <el-input v-model="form.manageDeviceRemark" placeholder="请输入备注" />
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
import { listDevice, getDevice, delDevice, addDevice, updateDevice, exportDevice } from "@/api/system/device";

export default {
  name: "Device",
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
      // 设备数据表格数据
      deviceList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        manageDeviceName: null,
        manageDeviceModel: null,
        manageDeviceWkshopid: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        manageDeviceName: [
          { required: true, message: "设备名称不能为空", trigger: "blur" }
        ],
        manageDeviceModel: [
          { required: true, message: "设备型号不能为空", trigger: "blur" }
        ],
        manageDeviceWkshopid: [
          { required: true, message: "设备所属车间ID不能为空", trigger: "blur" }
        ],
        manageDeviceRunstatus: [
          { required: true, message: "设备运行状态不能为空", trigger: "blur" }
        ],
        manageDeviceRundate: [
          { required: true, message: "设备开始运行日期不能为空", trigger: "blur" }
        ],
        manageDeviceRunhours: [
          { required: true, message: "设备运行时间不能为空", trigger: "blur" }
        ],
        manageDeviceScrapflag: [
          { required: true, message: "设备报废标志不能为空", trigger: "blur" }
        ],
        manageDeviceDelflag: [
          { required: true, message: "设备删除标志不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询设备数据列表 */
    getList() {
      this.loading = true;
      listDevice(this.queryParams).then(response => {
        this.deviceList = response.rows;
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
        manageDeviceId: null,
        manageDeviceName: null,
        manageDeviceModel: null,
        manageDeviceWkshopid: null,
        manageDeviceRunstatus: 0,
        manageDeviceRundate: null,
        manageDeviceRunhours: null,
        manageDeviceScrapflag: null,
        manageDeviceDelflag: null,
        manageDeviceRemark: null
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
      this.ids = selection.map(item => item.manageDeviceId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加设备数据";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const manageDeviceId = row.manageDeviceId || this.ids
      getDevice(manageDeviceId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改设备数据";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.manageDeviceId != null) {
            updateDevice(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDevice(this.form).then(response => {
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
      const manageDeviceIds = row.manageDeviceId || this.ids;
      this.$confirm('是否确认删除设备数据编号为"' + manageDeviceIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delDevice(manageDeviceIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有设备数据数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.exportLoading = true;
          return exportDevice(queryParams);
        }).then(response => {
          this.download(response.msg);
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
