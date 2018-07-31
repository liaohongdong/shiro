package cn.liaohongdong.common;

import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.session.mgt.SimpleSession;

@Setter
@Getter
public class OnlineSession extends SimpleSession {
    public static enum OnlineStatus {
        on_line("在线"),
        hidden("隐身"),
        force_logout("强制退出");
        private final String info;

        OnlineStatus(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }
    }

    public String userAgent;
    public OnlineStatus status = OnlineStatus.on_line;
    public String systemHost;
}
