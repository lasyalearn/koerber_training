package com.empapp.serviceproxy;


import com.empapp.dto.Department;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceProxyFallback implements DeptServiceProxy
{

    @Override
    public Department getByName(String name)
    {
        return new Department(0, "fallback", "fallback");
    }
}
