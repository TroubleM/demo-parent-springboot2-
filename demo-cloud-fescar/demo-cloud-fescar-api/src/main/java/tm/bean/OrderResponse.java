/*
 *  Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package tm.bean;

import java.io.Serializable;

/**
 * @auther: zhangyi
 * @date: 2019/3/14
 * @Description: 订单模块返回对象
 */
public class OrderResponse implements Serializable {

    /**
     * @auther: zhangyi
     * @date: 2019/3/14
     * @Description: 返回状态码
     */
    private String code;

    /**
     * @auther: zhangyi
     * @date: 2019/3/14
     * @Description: 返回消息
     */
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
