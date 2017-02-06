
<div class="span12">
    <div class="widget-box">
        <div class="widget-title"><span class="icon"> <i class="icon-align-justify"></i> </span>
            <h5>Upload jar</h5>
        </div>
        <div class="widget-content nopadding">
            <form id="jar_upload" action="${pageContext.request.contextPath}/uploadJar" method="POST" class="form-horizontal" enctype="multipart/form-data">
                <div class="control-group">
                    <label class="control-label">File upload input</label>
                    <div class="controls">
                        <input name="jobJar" type="file"/>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label">PackageName :</label>
                    <div class="controls">
                        <input name="packagesToScan" type="text" class="span6" placeholder="This is important!" />
                    </div>
                </div>
                <div class="form-actions">
                    <button type="submit" class="btn btn-success">Upload</button>
                </div>
            </form>
        </div>
    </div>
    </div>
