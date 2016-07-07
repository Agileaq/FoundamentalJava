package arc.bean;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Guoying on 2015/9/6.
 */
@XmlRootElement
public class UAUser implements Serializable {

    private static final long serialVersionUID = 9183261192899815426L;

    private Long id;

    private String name;

    private String email;

    private String phone;

    private Date lastLoginTime;

    private String lastLoginIp;

    private Byte failCount;

    private Integer groupId;

    private Boolean enabled;

    private Date createDate;

    private Date lastUpdate;

    private Date passwordDate;

    private String password;

    public Long getId() {
        return id;
    }

    public UAUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UAUser setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UAUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UAUser setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public UAUser setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        return this;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public UAUser setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
        return this;
    }

    public Byte getFailCount() {
        return failCount;
    }

    public UAUser setFailCount(Byte failCount) {
        this.failCount = failCount;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public UAUser setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public UAUser setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public UAUser setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public UAUser setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public Date getPasswordDate() {
        return passwordDate;
    }

    public UAUser setPasswordDate(Date passwordDate) {
        this.passwordDate = passwordDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UAUser uaUser = (UAUser) o;

        return !(id != null ? !id.equals(uaUser.id) : uaUser.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public String getPassword() {
        return password;
    }

    public UAUser setPassword(String password) {
        this.password = password;
        return this;
    }
}
