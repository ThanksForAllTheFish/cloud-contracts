import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'GET'
		url '/list'
	}
	response {
		status 200
		body(
			[
				content: [
					two: "something",
					three: [
						six: "seven"
					]
				]
			]
		)
		bodyMatchers {
			jsonPath('$.content.three.six', byRegex(".*seven.*"))
			jsonPath('$.content.two', byRegex(".*two.*"))
		}
	}
}