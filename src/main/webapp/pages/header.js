let getHeader = function () {
    return {
        rows: [
            {
                height: 53,
                cols: [
                    {
                        view: "button",
                        height: 52,
                        type: "image",
                        borderless: true,
                        disabled: true,
                        image: ""
                    },
                    {view: "template", role: "placeholder", borderless: true},
                    {view: "template", role: "placeholder", borderless: 1},
                    {view: "template", role: "placeholder", borderless: 1},
                    {label: "Sign in", view: "button", height: 52, borderless: 1},
                    {label: "Sign up", view: "button", height: 52, borderless: 1}
                ]
            }
        ]
    }
}