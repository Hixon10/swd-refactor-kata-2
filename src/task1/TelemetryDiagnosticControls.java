package task1;

public class TelemetryDiagnosticControls
{
  private final String DiagnosticChannelConnectionString = "*111#";

  private final TelemetryClient telemetryClient;
  private String diagnosticInfo = "";
  private int retryLeft = 0;

  public TelemetryDiagnosticControls(TelemetryClient telemetryClient, int retryLeft)
  {
    this.telemetryClient = telemetryClient;
    this.retryLeft = retryLeft;
  }

  public String getDiagnosticInfo(){
    return diagnosticInfo;
  }

  public void setDiagnosticInfo(String diagnosticInfo){
    this.diagnosticInfo = diagnosticInfo;
  }

  public void checkTransmission() throws Exception
  {
    diagnosticInfo = "";

    telemetryClient.disconnect();

    while (telemetryClient.getOnlineStatus() == false && retryLeft > 0)
    {
      telemetryClient.connect(DiagnosticChannelConnectionString);
      retryLeft -= 1;
    }

    if(telemetryClient.getOnlineStatus() == false)
    {
      throw new Exception("Unable to connect.");
    }

    telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
    diagnosticInfo = telemetryClient.receive();
  }
}