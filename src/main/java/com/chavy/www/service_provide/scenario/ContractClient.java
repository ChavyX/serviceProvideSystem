package com.chavy.www.service_provide.scenario;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chavy.www.service_provide.module.Contract;
import com.chavy.www.service_provide.module.dto.ContractQueryDTO;
import com.chavy.www.service_provide.result.CommonResult;
import com.chavy.www.service_provide.service.ContractService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("/contract")
public class ContractClient {

    @Resource
    private ContractService contractService;

    @PostMapping("/sign")
    public CommonResult<Void> sign(@RequestBody Contract contract) {
        return CommonResult.of(contractService.sign(contract));
    }

    @PostMapping("/select")
    public CommonResult<Page<Contract>> select(@RequestBody ContractQueryDTO contractQueryDTO) {
        return new CommonResult<Page<Contract>>().success(contractService.selectContract(contractQueryDTO.getContract(),
                contractQueryDTO.getSize(), contractQueryDTO.getCurrent()));
    }
}
