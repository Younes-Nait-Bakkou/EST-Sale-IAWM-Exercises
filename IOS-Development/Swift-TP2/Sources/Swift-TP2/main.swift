var laurent = User(firstName: "Laurent", lastName: "Alexandre", phoneNumber: "0123435366")
var raymond = User(firstName: "Raymond", lastName: "Kursweil", phoneNumber: "999994343")
var jacques = User(firstName: "Jacques", lastName: "Attali", phoneNumber: "5464656790")
var larry = User(firstName: "Larry", lastName: "Page", phoneNumber: "999994343")
var serguei = User(firstName: "Serguei", lastName: "Brin", phoneNumber: "999994343")

var socialNetworks: [SocialNetwork] = []

let facebook = SocialNetwork(name: "Facebook")
let twitter = SocialNetwork(name: "Twitter")

socialNetworks.append(facebook)
socialNetworks.append(twitter)

// Register facebook users
facebook.registerUser(user: laurent, email: "LA@mail", password: "LA", nickname: "LA")
facebook.registerUser(user: raymond, email: "RK@mail", password: "RK", nickname: "RK")
facebook.registerUser(user: larry, email: "LP@mail", password: "LP", nickname: "LP")
facebook.registerUser(user: jacques, email: "JA@mail", password: "JA", nickname: "JA")
facebook.registerUser(user: serguei, email: "SB@mail", password: "SB", nickname: "SB")

// Register twitter users
twitter.registerUser(user: laurent, email: "LATwitter@mail", password: "LATweet", nickname: "LAlex")
twitter.registerUser(
    user: raymond, email: "RaymondTwitter@mail", password: "RaymondTweet", nickname: "Raymond")
twitter.registerUser(
    user: jacques, email: "JacquesTwitter@mail", password: "JacquesTweet", nickname: "Jacques")
twitter.registerUser(
    user: larry, email: "LarryTwitter@mail", password: "LarryTweet", nickname: "Larry")

var globalNumberOfMembers: Int = 0
for network in socialNetworks {
    network.listMembers()
    globalNumberOfMembers += network.numberOfMembers()
}

print("Total number of networks: \(socialNetworks.count)")
print("Total number of members: \(globalNumberOfMembers)")
