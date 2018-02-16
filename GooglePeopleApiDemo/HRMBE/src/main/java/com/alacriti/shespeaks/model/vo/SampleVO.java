package com.alacriti.shespeaks.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;




@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2016-11-24T11:58:59.086+05:30")
public class SampleVO   {
  
  private String code = null;

  /**
   **/
  
  @JsonProperty("code")
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }

  /**
   **/
  
  

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SampleVO {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

