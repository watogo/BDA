#coding=UTF-8
import sys, getopt, json
from hubstorage import HubstorageClient

def main(argv):
	apikey = ''
	spider = ''
	
	try:
		opts, args = getopt.getopt(argv, "hi:o", ["apikey=","spider="])
	except getopt.GetoptError:
		print 'alljobs.py -k <API Key> -s <ProjectID\Spider>'
		sys.exit(2)
	for opt, arg in opts:
		if opt == '-h':
			print 'alljobs.py -k <API Key> -s <ProjectID\Spider>'
			sys.exit()
		elif opt in("-k", "--apikey"):
			apikey = arg		
		elif opt in("-s", "--spider"):
			spider = arg

	hc = HubstorageClient(auth=apikey)
	itemslist = hc.get_job(spider).items.list()
	
	itemslistIterator = itemslist.__iter__()
	for items in itemslistIterator:
		print json.dumps(items)

	
if __name__ == "__main__":
	main(sys.argv[1:])