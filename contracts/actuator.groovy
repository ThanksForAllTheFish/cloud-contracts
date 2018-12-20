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
					one: "two",
					two: "two",
					three: [
						six: "seven"
					]
				]
			]
		)
		bodyMatchers {
			jsonPath('$.content.three.six', byRegex(".*seven.*"))
			jsonPath('$.content.one', byRegex(".*two.*"))
		}
	}
}