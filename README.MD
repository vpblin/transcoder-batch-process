# Batch process files with AWS Elastic Transcoder

This is a useful file to automate AWS Elastic Transcoder jobs for S3 videos. Instead of rendering videos on multiple resolutions on local computers, AWS can process them much a lot faster. Just upload the Full HD videos on an S3 bucket, configure Transcoder with the settings you want, and use Transcoder.java to process as many videos as you need to.

## Getting Started

Create Java Maven project from Eclipse. To do this go to File > New > Maven Project. Put a Group ID and Artifact ID. These can be whatever you want.
Install the AWS SDK for Ecplise. You can do this by going to Help > Install New Software and search for AWS. This will prompt you to add an Access Key ID and Secret Access Key. Make sure this user has S3 and Transcoder Access.

Check the pom.xml file for the required resources that Transcoder.java uses.


### Prerequisites

Java SDK, Eclipse IDE and AWS Java SDK.

## Authors

* **Blin Kazazi** - [VPBLIN](https://github.com/vpblin)

## License

This project is licensed under the MIT License.

## Acknowledgments

* The AWS Sample Code was very helpful. https://docs.aws.amazon.com/elastictranscoder/latest/developerguide/sample-code.html#java-hls-link
