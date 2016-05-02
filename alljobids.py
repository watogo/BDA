import sys, getopt
from hubstorage import HubstorageClient

def main(argv):
	apikey = ''
	project = ''
	
	try:
		opts, args = getopt.getopt(argv, "hi:o", ["apikey=","project="])
	except getopt.GetoptError:
		print 'alljobs.py -k <API Key> -p <ProjectID>'
		sys.exit(2)
	for opt, arg in opts:
		if opt == '-h':
			print 'alljobs.py -k <API Key> -p <ProjectID>'
			sys.exit()
		elif opt in("-k", "--apikey"):
			apikey = arg
		elif opt in("-p", "--project"):
			project = arg
	
	hc = HubstorageClient(auth=apikey)
	project = hc.get_project(project)
	jobs_metadata = project.jobq.list()
	jobids = [j['key'] for j in jobs_metadata]
	jobidsUtf = [x.encode('UTF8') for x in jobids]
	print jobidsUtf

			

if __name__ == "__main__":
	main(sys.argv[1:])
	
		
	
	
