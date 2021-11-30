package AliCode.io;

public class TVchannel {

    String serverUrl;
    String ChName;

    public TVchannel( String ChNameX ,String serverUrlX)
    {
        if(ChNameX!=null && serverUrlX!=null)
        {
            this.serverUrl = serverUrlX;
            this.ChName = ChNameX;
        }

    }

    public String getServerUrl()
    {
        return serverUrl;
    }

    public String getChName()
    {
        return ChName;
    }






}
