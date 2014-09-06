# package for SOAP-Based service
require 'soap/wsdlDriver'

wsdl_url = 'http://localhost:9999/ws/hello?wsdl';

service = SOAP::WSDLDriverFactory.new(wsdl_url).create_rpc_driver

# invoke service operations.
data1 = service.getHelloWorldAsString('Nguyen Trong Cuong')

# output results
puts "getHelloWorldAsString : #{data1}"